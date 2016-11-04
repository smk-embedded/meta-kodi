LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file:///${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://github.com/Pulse-Eight/platform/archive/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "afe799001b48b53dfe93b2d9d14b6078"
SRC_URI[sha256sum] = "e97e45273e90571aa37732cde913b262f5f519c387083645d2557d7189c054cf"
S = "${WORKDIR}/platform-${PN}-${PV}"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DMAKE_BUILD_TYPE=Release -DBUILD_SHARED_LIBS=1"

FILES_${PN}-dev += "/usr/lib/platform/platform-config.cmake"

