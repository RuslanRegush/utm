import socket
import threading

HOST = "127.0.0.1"
PORT = 65432

def receive_messages(client_socket):
    while True:
        data = client_socket.recv(1024)
        print(f"Received from server: {data.decode()}")

# Create a socket
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))

    # Start a new thread to receive messages from the server
    receive_thread = threading.Thread(target=receive_messages, args=(s,))
    receive_thread.start()

    while True:
        message = input("Enter message: ")
        s.sendall(message.encode())
