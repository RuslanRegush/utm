import imaplib
import email
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

# Configurarea detaliilor pentru accesul la contul de email
email_address = 'storage.service.internship@gmail.com'
password = 'eexd fqwj gvwn adwf'

# Configurarea detaliilor serverului IMAP
imap_server = 'imap.gmail.com'
imap_port = 993

# Configurarea detaliilor serverului SMTP
smtp_server = 'smtp.gmail.com'
smtp_port = 587

def list_emails():
    # Conectare la serverul IMAP
    imap_connection = imaplib.IMAP4_SSL(imap_server, imap_port)
    imap_connection.login(email_address, password)

    # Selectarea folderului Inbox
    imap_connection.select('INBOX')

    # Căutarea email-urilor și afișarea lor
    _, email_ids = imap_connection.search(None, 'ALL')
    for email_id in email_ids[0].split():
        _, email_data = imap_connection.fetch(email_id, '(RFC822)')
        raw_email = email_data[0][1]
        msg = email.message_from_bytes(raw_email)
        print('From:', msg['From'])
        print('Subject:', msg['Subject'])
        print('Date:', msg['Date'])
        print('Body:')
        if msg.is_multipart():
            for part in msg.walk():
                if part.get_content_type() == 'text/plain':
                    print(part.get_payload(decode=True).decode('utf-8'))
        else:
            print(msg.get_payload(decode=True).decode('utf-8'))

    # Deconectare
    imap_connection.close()
    imap_connection.logout()

def send_email(receiver, subject, message, attachment_path=None):
    # Crearea mesajului
    msg = MIMEMultipart()
    msg['From'] = email_address
    msg['To'] = receiver
    msg['Subject'] = subject

    # Adăugarea conținutului mesajului
    msg.attach(MIMEText(message, 'plain'))

    # Adăugarea atașamentului, dacă există
    if attachment_path:
        attachment = open(attachment_path, "rb")
        part = MIMEBase('application', 'octet-stream')
        part.set_payload(attachment.read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', f"attachment; filename= {attachment_path}")
        msg.attach(part)

    # Conectarea la serverul SMTP și trimiterea mesajului
    smtp_connection = smtplib.SMTP(smtp_server, smtp_port)
    smtp_connection.starttls()
    smtp_connection.login(email_address, password)
    smtp_connection.sendmail(email_address, receiver, msg.as_string())
    smtp_connection.quit()

# Exemplu de utilizare:
print("Emails in Inbox:")
list_emails()

# Trimite un email
send_email('ruslan.regush@gmail.com', 'Subject of the Email', 'Body of the Email', 'salut.txt')
