SUMMARY = "Kodi Media Center"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=930e2a5f63425d8dd72dbd7391c43c46"

include kodi-git.inc

SRC_URI += " \
	file://0001-dvdplayer-add-freescale-header-from-3.14-kernel.patch \
	file://kodi.service \
	file://kodi \
"

DEPENDS = "\
	avahi \
	boost \
	bzip2 \
	curl \
	crossguid \
	expat \
	enca \
	fribidi \
	ffmpeg-kodi \
	faad2 \
	fontconfig \
	giflib \
	jasper \
	libssh \
	libxslt \
	libdcadec \
	libass \
	libmms \
	libmodplug \
	libmicrohttpd \
	libplist \
	libvorbis \
	libogg \
	libmms \
	libtinyxml \
	libmad \
	libcdio \
	libsamplerate0 \
	libpcre \
	lsb \
	lzo \
	mpeg2dec \
	mysql5 \
	python \
	squish \
	sqlite3 \
	taglib \
	tiff \
	virtual/gettext \
	wavpack \
	yajl \
	zlib \
"
DEPENDS += "\
	cmake-native \
	gperf-native \
	gettext-native \
	jsonschemabuilder-native \
	swig-native \
	texturepacker-native \
	zip-native \
"

inherit autotools-brokensep python-dir systemd bluetooth

SYSTEMD_SERVICE_${PN} = "kodi.service"

#BUG: offering both sysvinit and systemd fails on run-postinst
#inherit  update-rc.d
#INITSCRIPT_NAME = "kodi"

PACKAGECONFIG ??= "udev alsa airplay airtunes samba bluez5 nfs"
PACKAGECONFIG_append_mx6 = " openglesv2 imx-vpu cec"
RDEPENDS_${PN}_append_mx6 = " libegl libgles2-mx6 libgles2 libgal-mx6 libvivante-mx6 libopencl-mx6 libglslc-mx6 libclc-mx6"
PACKAGECONFIG_append_x86 = " opengl wayland"
RDEPENDS_${PN}_append_x86 = " weston weston-init mesa-megadriver"
PACKAGECONFIG_append_x86-64 = " opengl wayland"
RDEPENDS_${PN}_append_x86-64 = " weston weston-init mesa-megadriver"

PACKAGECONFIG[opengl] = "--enable-gl,--disable-gl,glew virtual/libgl"
PACKAGECONFIG[openglesv2] = "--enable-gles,--disable-gles,virtual/egl virtual/libgles2"
PACKAGECONFIG[imx-vpu] = "--enable-codec=imxvpu,,virtual/kernel imx-vpu libfslvpuwrap,imx-gpu-viv-g2d libfslvpuwrap"
PACKAGECONFIG[imx-cec] = "--enable-libcec,--disable-libcec,libcec-imx"
PACKAGECONFIG[openmax] = "--enable-openmax,--disable-openmax"
PACKAGECONFIG[cec] = "--enable-libcec,--disable-libcec,libcec,libcec"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11"
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa"
PACKAGECONFIG[pulseaudio] = "--enable-pulse,--disable-pulse,pulseaudio"
PACKAGECONFIG[airplay] = "--enable-airplay,--disable-airplay,libplist"
PACKAGECONFIG[airtunes] = "--enable-airtunes,--disable-airtunes,shairplay"
# kodi uses dlopen() for libcec so we need to add it manually
PACKAGECONFIG[udev] = "--enable-udev,--disable-udev,udev"
#libusb is only required if no udev is available
PACKAGECONFIG[libusb] = "--enable-libusb,,libusb1"
PACKAGECONFIG[samba] = "--enable-samba,--disable-samba,samba"
PACKAGECONFIG[nfs] = "--enable-nfs,--disable-nfs,libnfs"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland"
PACKAGECONFIG[bluez5] = ",,bluez5"

CACHED_CONFIGUREVARS += " \
    ac_cv_path_PYTHON="${STAGING_BINDIR_NATIVE}/python-native/python" \
"

EXTRA_OECONF = " \
    gl_cv_func_gettimeofday_clobber=no \
    ac_cv_lib_bluetooth_hci_devid=no \
    ac_cv_func_mmap_fixed_mapped=no \
    --with-ffmpeg=shared \
    --enable-optical-drive \
    --disable-vtbdecoder \
    --disable-tegra \
    --disable-ccache \
    --disable-libcap \
    --disable-mid \
    --disable-asap-codec \
    --enable-gif \
    --enable-texturepacker \
"
#DEBUGGINF
#EXTRA_OECONF += " \
#    --enable-debug \
#    --enable-profiling \
#    --disable-optimizations \
#"
EXTRA_OECONF += " \
    --disable-debug \
    --disable-profiling \
    --enable-optimizations \
"

# for python modules
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
export PYTHON_DIR

do_configure() {
    ./bootstrap
    oe_runconf
}

do_compile_prepend() {
    for i in $(find . -name "Makefile") ; do
        sed -i -e 's:I/usr/include:I${STAGING_INCDIR}:g' $i
    done

    for i in $(find . -name "*.mak*" -o    -name "Makefile") ; do
        sed -i -e 's:I/usr/include:I${STAGING_INCDIR}:g' -e 's:-rpath \$(libdir):-rpath ${libdir}:g' $i
    done
}

do_install_append() {
      if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)};then
                install -Dm 0644 ${WORKDIR}/kodi.service ${D}${systemd_unitdir}/system/kodi.service
        else
                install -Dm 0755 ${WORKDIR}/kodi ${D}${sysconfdir}/init.d/kodi
        fi
}

FILES_${PN} += "${libdir}/xbmc ${datadir}/xbmc ${datadir}/xsessions ${datadir}/icons ${systemd_unitdir}"
FILES_${PN}-dbg += "\
	${libdir}/kodi/*/.debug \
	${libdir}/kodi/*/*/.debug \
	${libdir}/kodi/*/*/*/.debug \
"

RRECOMMENDS_${PN}_append = " \
    python \
    python-lang \
    python-re \
    python-netclient \
    python-json \
    libcurl \
"

RRECOMMENDS_${PN}_append_libc-glibc = " \
    glibc-charmap-ibm850 \
    glibc-gconv-ibm850 \
    glibc-gconv-utf-32 \
    glibc-charmap-utf-8 \
"
