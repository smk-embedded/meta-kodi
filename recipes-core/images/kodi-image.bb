SUMMARY = "Default image for the Kodi on Yocto distribution"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL += "\
    packagegroup-core-boot \
    kodi \
    connman \
    rsync \
    python-pip \
"
