LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file:///${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://github.com/Pulse-Eight/platform/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "4ac07e020227d3cbe54351ec3837ba48"
SRC_URI[sha256sum] = "6ba3239cb1c0a5341efcf9488f4d3dfad8c26d6b2994b2b2247e5a61568ab5cd"
S = "${WORKDIR}/platform-${PV}"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DMAKE_BUILD_TYPE=Release -DBUILD_SHARED_LIBS=1"

FILES_${PN}-dev += "/usr/lib/platform/platform-config.cmake"

