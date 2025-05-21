class VendingMachine {
    int money = 0;
    /* 売り切れ状態と未登録状態を区別するために配列の要素全てに-1のフラグを建てる */
    int[] stock_array = {-1, -1, -1, -1, -1};
    Drink[] drink_array = new Drink[5];

    /* 自動販売機に登録する処理 */
    public void registDrink(int index, Drink drink, int stock) {
        if (this.stock_array[index - 1] == -1) {
            this.stock_array[index - 1] = stock;
            this.drink_array[index - 1] = drink;
            System.out.println(index + "番に「" + drink.getName() + "」を" + this.stock_array[index - 1] + "個登録しました");
        } else {
            System.out.println(index + "番にはすでに飲みものが登録されています");
        }
    }

    /* 現在投入されている金額の表示 */
    public void insertMoney(int money) {
        System.out.println("現在" + (this.money += money) + "円入っています");
    }

    /* 仕様書閲覧(購入の処理) */
    public void buyDrink(int index) {
    /* 購入失敗の場合 */
        /* 未登録の場合 */
        if (this.stock_array[index - 1] == -1) {
            System.out.println("購入できませんでした(" + index + "番には飲み物が登録されていません)");
        /* 売り切れの場合 */
        } else if (this.stock_array[index - 1] == 0) {
            System.out.println("購入できませんでした(売り切れています)");
        /* 金額が足りない場合 */
        } else if (this.drink_array[index - 1].getPrice() > this.money) {
            System.out.println("購入できませんでした(お金が足りません)");
        }
    /* 購入可能な場合 */
            else {
                this.money -= this.drink_array[index - 1].getPrice();
                this.stock_array[index - 1]--;
                System.out.println(index + "番の「" + drink_array[index - 1].getName() +"」を購入しました");
            }
    }

    /* 釣りの返却，投入金額を0に，お釣りの出力 */
    public void returnMoney() {
        System.out.println(this.money + "円のお釣りを出力しました");
        this.money = 0;
    }

    /* 登録されている飲みのもの情報と売り切れの表示 */
    public void printInfo() {
        System.out.println("===================================");
        for (int i = 0; i < 5; i++) {
            if (stock_array[i] > 0) {
                /* 個数が1以上のとき */
                System.out.println((i + 1) + "番 " + this.drink_array[i].getName() + " " + this.drink_array[i].getPrice() + "円 " + this.stock_array[i] + "個");
            } else if (stock_array[i] == 0) {
                /* 個数がゼロのとき(売切の場合) */
                System.out.println((i + 1) + "番 " + this.drink_array[i].getName() + " " + this.drink_array[i].getPrice() + "円 " + "売切");
            } else {
                /* 個数が-1のとき(未登録のとき) */
                System.out.println("-----未登録-----");
            }
        }
        System.out.println("===================================");
    }
}