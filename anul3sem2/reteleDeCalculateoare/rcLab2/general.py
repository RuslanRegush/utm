import socket

UDP_IP = "127.0.0.1"
UDP_PORT = 5005

# Socket UDP
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_socket.bind((UDP_IP, UDP_PORT))

try:
    print("Serverul este pregătit să primească mesaje...")

    while True:
        data, client_address = server_socket.recvfrom(1024)
        
        message = data.decode()
        if message.startswith("MSG_PRIVATE:"):
            # Ignorăm mesajele private în canalul general
            continue

        print("Mesaj de la {}: {}".format(client_address, message))

        # Trimitem confirmare că mesajul a fost primit
        server_socket.sendto(b"Mesaj primit de la server.", client_address)

finally:
    server_socket.close()
