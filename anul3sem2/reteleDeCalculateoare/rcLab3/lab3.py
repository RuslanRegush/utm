import socket

class DNSClient:
    def __init__(self):
        self.current_dns = socket.gethostbyname(socket.gethostname())

    def resolve_domain(self, domain):
        try:
            ip_addresses = socket.gethostbyname_ex(domain)[-1]
            print("IP addresses for domain", domain, ":", ip_addresses)
        except socket.gaierror:
            print("DNS could not resolve domain", domain)

    def resolve_ip(self, ip):
        try:
            domain_names = socket.gethostbyaddr(ip)[0]
            print("Domain names for IP", ip, ":", domain_names)
        except socket.herror:
            print("DNS could not resolve IP", ip)

    def use_dns(self, new_dns):
        try:
            socket.gethostbyname(new_dns)
            self.current_dns = new_dns
            print("DNS server changed to", new_dns)
        except socket.gaierror:
            print("Invalid DNS server address")

    def start(self):
        while True:
            command = input("Enter command: ").split()
            if command[0] == "resolve":
                if len(command) == 2:
                    if command[1].isdigit():  # IP address provided
                        self.resolve_ip(command[1])
                    else:  # Domain name provided
                        self.resolve_domain(command[1])
                else:
                    print("Invalid command format. Usage: resolve <domain> or resolve <ip>")
            elif command[0] == "use" and command[1] == "dns":
                if len(command) == 3:
                    self.use_dns(command[2])
                else:
                    print("Invalid command format. Usage: use dns <ip>")
            else:
                print("Invalid command")

if __name__ == "__main__":
    client = DNSClient()
    client.start()
