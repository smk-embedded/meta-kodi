SUMMARY = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e61fd86f9c947b430126181da2c6c715"

DEPENDS = "udev lockdev p8-platform"
DEPENDS_rpi3 += "bcm2835-firmware"

SRC_URI = "https://github.com/Pulse-Eight/libcec/archive/libcec-${PV}.tar.gz"
SRC_URI[md5sum] = "216ab1a5f04300dcad9d5b5d67ef9100"
SRC_URI[sha256sum] = "7e3670c8949a1964d6e5481f56dfff838857da10bdc60b506f6e9b7f117e253e"
S = "${WORKDIR}/libcec-libcec-${PV}"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_SHARED_LIBS=1 \
    -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST} \
"
EXTRA_OECMAKE_append_mx6 = " -DHAVE_IMX_API=1"

PACKAGES += "python-cec"
FILES_python-cec += "${libdir}/python*/*/cec"
FILES_${PN}-dbg += "${libdir}/python*/*/*/.debug"
