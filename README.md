meta-kodi, Yocto Layer for Kodi Mediacenter
===========================================

This is a Yocto layer for Kodi. It supports NXP i.MX 6 family of ARM
processors and generic x86 architecture.

- i.MX 6 support has been tested on the Wandboard using the community
  BSP jethro branch. Thd kodi-image is running egl on framebuffer with
  vpu support.
- x86 support has been tested on Thinkpad 2nd gen Core i5. It uses
  Wayland with Weston.

There are some rough edges that can easily be tweaked. Help is welcome!

Instructions i.MX 6
===================

Install the FSL community BSP jethro branch and add meta-kodi to your
bblayers.conf. Use the settings meta-kodi/conf/local.conf.sample for a
bit more of an out-of-the-box feeling.

bitbake kodi-image

Then copy the image onto a sdcard:

dd if=tmp/deploy/images/wandboard/kodi-image-wandboard.sdcard of=/dev/<yourcard> bs=4M
