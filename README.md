# opemane
SpringBoot学習用として作成した稼働管理アプリ

## フォルダの説明
```
opemane
├ src // ソースフォルダ
├ mockoon-config // 外部システムのAPIを使用するテイであるため、Mockoonにてモックするための設定ファイル
└ eclipse-setting // コードフォーマット等のEclipse向け設定
```

## やりたいこと

### Thymealeafを使用して静的ファイルとして成立するHTMLの作成

アプリケーションを動作させないとHTMLファイルがブラウザで解析された結果がわからない、ということが起きないようにそのままブラウザで開いても成立するようにHTMLファイルを記述する。

### Mybatisを使用したDBアクセス

XMLファイルは使用せず、アノテーションベースでSQLを記述する方針で記述する。

### 外部APIの呼び出し

RestTemplateがSpring5.0でメンテナンスモードとなっているため、Webclientを使用したAPI呼び出しの記述をする。

### クライアントからAjaxによる通信を行う処理を盛りこむ

jQueryもしくはaxiosを使用して実装を行う。