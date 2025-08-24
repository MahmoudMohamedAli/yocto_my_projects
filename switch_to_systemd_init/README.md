# Use SystemD instaed of Systemvinit

by default Yocto use systemv init so to switch to systemd you need to add these lines in 
distro.conf

---
#### NOTE
- you can check your distro from local.conf
- ex: if your distro is poky
- you have to go under meta-poky/conf/distro/poky.conf and add the lines

---

```bitbake
DISTRO_FEATURES:append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
```
### next step
```
bitbake ur_image
```
you should now see systemd is running instaed of systemv init