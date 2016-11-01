include recipes-multimedia/libav/libav.inc

SRC_URI = "https://github.com/xbmc/FFmpeg/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "7f60631a38e7fb604356c4649a1beb86"
SRC_URI[sha256sum] = "567171041491f6ea2eba9b4cda573cf864eeda67fd5c06a1bd82a2244e5ae8e2"

S = "${WORKDIR}/FFmpeg-${PV}"

PROVIDES = "ffmpeg"

EXTRA_OECONF += "--disable-stripping"
EXTRA_OECONF_remove = "--enable-avserver --enable-avplay"

PACKAGECONFIG_append = " xz theora libvorbis"
PACKAGECONFIG[xz] = "--enable-lzma,--disable-lzma,xz"

FILES_${PN}-dev += "${datadir}"
