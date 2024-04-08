https://dev.to/lorenzoarena/first-steps-with-the-kas-build-system-37hn
https://docs.yoctoproject.org/kernel-dev/common.html?highlight=bbappend

https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097
https://www.konsulko.com/getting-started-with-rauc-on-raspberry-pi-2

```
bitbake update-bundle
```

## problems

* [x] trying to make update-bundle happen as part of kas build
* [!!!!] verifying that update-bundle.bb is overwritten to use rootfs of expected image
* double-checking that build works with non-dirty dependencies
