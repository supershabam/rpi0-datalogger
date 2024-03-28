SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5ebcb90236d1ad640558c3d3cd3035df \
                    file://README;beginline=1;endline=56;md5=e3d2f6c2948991e37c1ca4960de84747 \
                    file://wpa_supplicant/wpa_supplicant.c;beginline=1;endline=12;md5=76306a95306fee9a976b0ac1be70f705"

# FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant-nl80211-wlan0.conf"

# SYSTEMD_AUTO_ENABLE = "enable"
# SYSTEMD_SERVICE:${PN}:append = " wpa_supplicant-nl80211@wlan0.service "

do_install:prepend () {
   bbwarn "from do install in append"

   install -d ${D}${sysconfdir}/wpa_supplicant/
   install -D -m 600 ${WORKDIR}/wpa_supplicant-nl80211-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/

   install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
   ln -s ${systemd_unitdir}/system/wpa_supplicant@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant-nl80211@wlan0.service
#    ln -s ${systemd_unitdir}/system/wpa_supplicant-nl80211@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant-nl80211@wlan0.service   
}
