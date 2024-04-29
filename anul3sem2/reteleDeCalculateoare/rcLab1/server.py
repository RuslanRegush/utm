import socket
import threading

HOST = "127.0.0.1"
PORT = 65432

# List to hold all client connections
clients = []

def handle_client(client_socket, client_address):
    print(f"Connected by {client_address}")
    with client_socket:
        while True:
            data = client_socket.recv(1024)
            if not data:
                break
            print(f"Received from {client_address}: {data.decode()}")
            # Broadcast message to all clients except the sender
            for c in clients:
                if c != client_socket:
                    c.sendall(data)

# Create a socket
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    print("Server is listening...")

    while True:
        conn, addr = s.accept()
        # Add client connection to the list
        clients.append(conn)
        # Start a new thread to handle client communication
        client_thread = threading.Thread(target=handle_client, args=(conn, addr))
        client_thread.start()
