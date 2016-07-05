LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=930e2a5f63425d8dd72dbd7391c43c46"

DEPENDS = "giflib libpng"

include kodi-git.inc

inherit gettext

do_configure () {
}

CFLAGS += "-std=gnu99"
export PREFIX="${prefix}"

do_compile (){
    make -C ${S}/tools/depends/native/TexturePacker/
}

do_install() {
    install -Dm 775 ${S}/tools/depends/native/TexturePacker/bin/TexturePacker ${D}${bindir}/TexturePacker
}

BBCLASSEXTEND = "native nativesdk"
