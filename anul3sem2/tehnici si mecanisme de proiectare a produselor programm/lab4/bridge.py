# Bridge Design Pattern

# Device Implementations
class Device:
    def __init__(self, device_name):
        self.device_name = device_name

    def power_on(self):
        pass

    def power_off(self):
        pass

    def set_channel(self, channel):
        pass


class TV(Device):
    def power_on(self):
        print(f"{self.device_name}: TV powered on")

    def power_off(self):
        print(f"{self.device_name}: TV powered off")

    def set_channel(self, channel):
        print(f"{self.device_name}: Set channel to {channel}")


class Radio(Device):
    def power_on(self):
        print(f"{self.device_name}: Radio powered on")

    def power_off(self):
        print(f"{self.device_name}: Radio powered off")

    def set_channel(self, channel):
        print(f"{self.device_name}: Set frequency to {channel}")


# Remote Control Implementations
class Remote:
    def __init__(self, device):
        self.device = device

    def power_on(self):
        self.device.power_on()

    def power_off(self):
        self.device.power_off()


class BasicRemote(Remote):
    def __init__(self, device):
        super().__init__(device)

    def power_on(self):
        print("Basic remote:")
        super().power_on()

    def power_off(self):
        print("Basic remote:")
        super().power_off()


class AdvancedRemote(Remote):
    def __init__(self, device):
        super().__init__(device)

    def power_on(self):
        print("Advanced remote:")
        super().power_on()

    def power_off(self):
        print("Advanced remote:")
        super().power_off()

    def set_channel(self, channel):
        print("Advanced remote:")
        self.device.set_channel(channel)



tv = TV("Living Room TV")
radio = Radio("Kitchen Radio")

basic_remote = BasicRemote(tv)
basic_remote.power_on()
basic_remote.power_off()

advanced_remote = AdvancedRemote(radio)
advanced_remote.power_on()
advanced_remote.set_channel(101)
advanced_remote.power_off()
