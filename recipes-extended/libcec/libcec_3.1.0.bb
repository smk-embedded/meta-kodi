SUMMARY = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e61fd86f9c947b430126181da2c6c715"

DEPENDS = "udev lockdev p8-platform python"
DEPENDS_rpi3 += "bcm2835-firmware"

SRC_URI = "https://github.com/Pulse-Eight/libcec/archive/libcec-${PV}.tar.gz"
SRC_URI[md5sum] = "f77141155906c3cd8660e751e63c6d4a"
SRC_URI[sha256sum] = "09109d21a1b03f42c9e341d12600f2e4c41038d640269fa75408e2d36126f921"
SRC_URI += "\
    file://0001-pr208-status-merged.patch \
    file://0002-libcec-00-imx6-support.patch \
    file://0003-libcec-01-imx6-p8-platform.patch \
    file://0004-libcec-03-amlogic-support.patch \
"
#PATCHTOOL = "git"

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
