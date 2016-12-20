LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "giflib libpng squish"

include kodi-git.inc

inherit gettext autotools-brokensep

S_append := "/tools/depends/native/TexturePacker/src"

EXTRA_OEMAKE = "AM_LDFLAGS="

BBCLASSEXTEND = "native nativesdk"
