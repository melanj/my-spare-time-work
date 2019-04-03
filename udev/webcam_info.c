#include <libudev.h>
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <unistd.h>

int main(void) {
  struct udev * udev;
  struct udev_enumerate * enumerate;
  struct udev_list_entry * devices, * dev_list_entry;
  struct udev_device * dev;

  /* Create the udev object */
  udev = udev_new();
  if (!udev) {
    printf("Can't create udev\n");
    exit(1);
  }

  /* Create a list of the devices in the 'video4linux' subsystem. */
  enumerate = udev_enumerate_new(udev);
  udev_enumerate_add_match_subsystem(enumerate, "video4linux");
  udev_enumerate_scan_devices(enumerate);
  devices = udev_enumerate_get_list_entry(enumerate);
  /* For each item enumerated, print out its information. */
  udev_list_entry_foreach(dev_list_entry, devices) {
    const char * path;

    /* Get the filename of the /sys entry for the device
       and create a udev_device object (dev) representing it */
    path = udev_list_entry_get_name(dev_list_entry);
    dev = udev_device_new_from_syspath(udev, path);

    /* usb_device_get_devnode() returns the path to the device node
       itself in /dev. */
    printf("Device Node Path: %s\n", udev_device_get_devnode(dev));

    dev = udev_device_get_parent_with_subsystem_devtype(
      dev,
      "usb",
      "usb_device");
    if (!dev) {
      printf("Unable to find parent usb device.");
      exit(1);
    }

    /* From here, we can call get_sysattr_value() for each file
       in the device's /sys entry. The strings passed into these
       functions (idProduct, idVendor, serial, etc.) */
    printf("  VID/PID: %s %s\n",
      udev_device_get_sysattr_value(dev, "idVendor"),
      udev_device_get_sysattr_value(dev, "idProduct"));
    printf("  Manufacturer: %s\n  Product: %s\n",
      udev_device_get_sysattr_value(dev, "manufacturer"),
      udev_device_get_sysattr_value(dev, "product"));
    printf("  Serial: %s\n",
      udev_device_get_sysattr_value(dev, "serial"));
    udev_device_unref(dev);
  }
  /* Free the enumerator object */
  udev_enumerate_unref(enumerate);

  udev_unref(udev);

  return 0;
}
