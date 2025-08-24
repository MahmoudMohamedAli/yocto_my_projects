#include <stdio.h>
#include <unistd.h>

int main() {
    while (1) {
        printf("Hello, Yocto systemd!\n");
        fflush(stdout);
        sleep(10);
    }
    return 0;
}