SUMMARY =  "KODI mediacenter"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash ssh-server-openssh tools-debug tools-profile debug-tweaks"

IMAGE_INSTALL += "\
    packagegroup-core-boot \
    kodi \
    libdrm-tests \
"
