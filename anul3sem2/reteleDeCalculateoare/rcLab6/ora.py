import ntplib
from datetime import datetime
import pytz

def get_ntp_time():
    client = ntplib.NTPClient()
    response = client.request('pool.ntp.org')
    utc_time = datetime.utcfromtimestamp(response.tx_time).replace(tzinfo=pytz.utc)
    return utc_time

def get_local_time(zone):
    utc_time = get_ntp_time()

    try:
        # Construim fusul orar folosind pytz
        if zone.startswith("GMT"):
            offset = int(zone[3:])
            timezone = pytz.FixedOffset(offset * 60)
            local_time = utc_time.astimezone(timezone)
        else:
            print("Formatul zonei geografice este incorect.")
            return None

    except ValueError:
        print("Formatul zonei geografice este incorect.")
        return None

    return local_time

def main():
    zone = input("Introduceți zona geografică (în format 'GMT+X' ori 'GMT-X'): ")
    local_time = get_local_time(zone)
    if local_time:
        print(f"Ora exactă pentru zona {zone} este: {local_time.strftime('%Y-%m-%d %H:%M:%S %Z%z')}")

if __name__ == "__main__":
    main()
