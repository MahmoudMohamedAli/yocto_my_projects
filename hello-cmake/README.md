# Compile c++ project

please add the following line in local.conf

```
IMAGE_INSTALL:append = libstdc++ 
```
to compile c++ project successfully  but for c projects the glibc is installed by default.