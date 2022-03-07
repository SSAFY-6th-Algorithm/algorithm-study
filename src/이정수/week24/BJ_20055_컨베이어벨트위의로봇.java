package week24;

import java.util.Scanner;


/**
 * ����: �����̾� ��Ʈ ���� �κ�
 * ��ũ: https://www.acmicpc.net/problem/20055
 * 
 * Ǯ��:
 * 1. 1���� �迭�� �����̾� ��Ʈ ǥ��
 * 2. on�� off��� �ε����� �κ� �ø��� ��ġ�� ������ ��ġ ǥ��
 * 3. on, off�� �̵����Ѽ� ȸ��ǥ��
 * 
 * 
 * �ð����⵵:
 * ?
 * 
 * Ǯ�̿� �ɸ� �ð�:
 * 2h
 *
 */
public class BJ_20055_�����̾Ʈ���Ƿκ� {

    static class Node{
    	
        boolean isRobotOn;
        int durability;

        public Node(int durability) {
            this.durability = durability;
        }

		@Override
		public String toString() {
			return "Node [isRobotOn=" + isRobotOn + ", durability=" + durability + "]";
		}
        
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Node[] belt = new Node[2*N];

        int on = 0;     // �κ� �ø��� ��ġ
        int off = N-1;  // �κ� ������ ��ġ

        // ��Ʈ ���� �ʱ�ȭ
        for (int i = 0; i < 2*N; i++) {
            belt[i] = new Node(sc.nextInt());
        }

        int cnt = 0;
        

        while(K>0){

            ///////////////////////////////////////////////////////// ��Ʈ ȸ��
            

            if(off==0){
                off = 2*N -1;
            }else{
                off --;
            }

            if(on==0){
                on = 2*N -1;
            }else{
                on--;
            }
            
            belt[off].isRobotOn = false; // �κ� ������

            ///////////////////////////////////////////////////////// �κ� �̵�
            if(on<off){
                for (int i = off; i > on ; i--) {
                    // ����ĭ�� �κ��� ���� �������� 0���� ũ�� ��ĭ�� �κ��� ������
                    if(!belt[i].isRobotOn && belt[i].durability>0 && belt[i-1].isRobotOn){
                        // ��ĭ�� �κ� ��ĭ ������ �̵�
                        belt[i-1].isRobotOn = false;
                        belt[i].isRobotOn = true;
                        belt[i].durability--;
                        if(belt[i].durability==0) {
                        	K--;
                        }
                    }
                }
            }else{
                for (int i = off; i > 0; i--) {
                    // ����ĭ�� �κ��� ���� �������� 0���� ũ�� ��ĭ�� �κ��� ������
                    if(!belt[i].isRobotOn && belt[i].durability>0 && belt[i-1].isRobotOn){
                        // ��ĭ�� �κ� ��ĭ ������ �̵�
                        belt[i-1].isRobotOn = false;
                        belt[i].isRobotOn = true;
                        belt[i].durability--;
                        if(belt[i].durability==0) {
                        	K--;
                        }
                    }
                }
                // ����ĭ�� �κ��� ���� �������� 0���� ũ�� ��ĭ�� �κ��� ������
                if(!belt[0].isRobotOn && belt[0].durability>0 && belt[2*N-1].isRobotOn){
                    // ��ĭ�� �κ� ��ĭ ������ �̵�
                    belt[2*N-1].isRobotOn = false;
                    belt[0].isRobotOn = true;
                    belt[0].durability--;
                    if(belt[0].durability==0) {
                    	K--;
                    }
                }
                for (int i = 2*N-1; i > on; i--) {
                    // ����ĭ�� �κ��� ���� �������� 0���� ũ�� ��ĭ�� �κ��� ������
                    if(!belt[i].isRobotOn && belt[i].durability>0 && belt[i-1].isRobotOn){
                        // ��ĭ�� �κ� ��ĭ ������ �̵�
                        belt[i-1].isRobotOn = false;
                        belt[i].isRobotOn = true;
                        belt[i].durability--;
                        if(belt[i].durability==0) {
                        	K--;
                        }
                    }
                }
            }
            
            belt[off].isRobotOn = false; // �κ� ������

            ////////////////////////////////////////////////////// �κ� �ø���
            if(belt[on].durability>0){
                belt[on].isRobotOn = true;
                belt[on].durability--;
                if(belt[on].durability==0) {
                	K--;
                }
            }
            cnt++;

        }

        System.out.println(cnt);
    }
}
