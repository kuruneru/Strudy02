import java.util.Scanner;

class Study02 {
    public static void main(String[] args) {

        /* このファイルで使う変数宣言 */
        Scanner scan = new Scanner(System.in);
        int money;

        /* 飲み物のインスタンス化 */
        Drink drink1 = new Drink("ソーダ", 130);
        Drink drink2 = new Drink("コーラ", 130);
        Drink drink3 = new Drink("天然水", 100);
        Drink drink5 = new Drink("玄米茶", 120);

        /* 自動販売機のクラスのインスタンス化 */
        VendingMachine venmach = new VendingMachine();

        /* 登録の処理 */
        venmach.registDrink(1, drink1, 1);
        venmach.registDrink(1, drink2, 4);
        venmach.registDrink(2, drink2, 2);
        venmach.registDrink(3, drink3, 5);
        venmach.registDrink(5, drink5, 2);

        /* ターミナルの見やすくするための改行 */
        System.out.println();

        venmach.printInfo();
        
        /* ターミナルの見やすくするための改行 */
        System.out.println();
        venmach.insertMoney(0);

        System.out.println();

        while(true) {
            System.out.println("行いたい操作を指定してください");
            System.out.print("（1: お金の投入，2: 飲み物の購入，3: お釣りの返却，4: 終了 > ");
            switch (scan.nextInt()) {
                case 1 -> { /* お金の投入 */
                    System.out.print("投入する金額を指定してください > ");
                    money = scan.nextInt();
                    System.out.println(money + "円を投入しました");
                    venmach.insertMoney(money);
                }

                case 2 -> { /* 飲み物の購入 */
                    System.out.print("購入する飲み物の番号を指定してください > ");
                    venmach.buyDrink(scan.nextInt());
                    System.out.println();
                    venmach.printInfo();
                    venmach.insertMoney(0);
                }

                case 3 -> { /* お釣りの返却 */
                    venmach.returnMoney();
                }

                case 4 -> { /* 終了 */
                    return;
                }

                default -> {
                    System.out.println("1~4の数字の中から選択してください");
                }

            }

            System.out.println();
        }
    }
}