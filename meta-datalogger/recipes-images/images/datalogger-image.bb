SUMMARY = "datalogger image"
LICENSE = "MIT"

IMAGE_INSTALL = "wpa-supplicant"
inherit core-image

IMAGE_FEATURES += "ssh-server-openssh"
