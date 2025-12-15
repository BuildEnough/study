package oop1;

import org.w3c.dom.ls.LSOutput;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume = 0;
        boolean isOn = false;

        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");

        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
        volume--;
        System.out.println("음악 플레이어 볼륨: " + volume);

        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 On, 현재 볼륨: " + volume);
        } else {
            System.out.println("음악 플에이어 Off");
        }

        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");

    }
}
