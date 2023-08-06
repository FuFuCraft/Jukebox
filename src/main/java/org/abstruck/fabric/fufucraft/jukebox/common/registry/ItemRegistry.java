package org.abstruck.fabric.fufucraft.jukebox.common.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.abstruck.fabric.fufucraft.jukebox.common.item.RecordItem;
import org.abstruck.fabric.fufucraft.jukebox.util.RegistryUtils;

import java.util.List;

/**
 * @author Astrack
 * @date 2023/7/21
 */
public class ItemRegistry {
    /*
    1.ogg	magical mirai 主题曲黑胶唱片	41:42
2.ogg	八王子p精选集黑胶唱片	33:30
3.ogg	2021 magical mirai 黑胶唱片	39:17
4.ogg	DECO 精选集黑胶唱片	31:40
5.ogg	wowaka 精选集黑胶唱片	31:41
6.ogg	老匹精选集黑胶唱片	32:44
7.ogg	雪未来主题黑胶唱片	45:39
8.ogg	MitchieM精选集黑胶唱片	14:58
     */
    private static final Item.Settings SETTINGS = new Item.Settings().maxCount(1).rarity(Rarity.RARE);
    public static final Item ALBUM1 = new RecordItem(giteeRaw("1"),SETTINGS,41*60+42,
            List.of(formattedText("魔法未来从2014-2023年的主题歌曲",'d'),
                    formattedText("歌曲名单",'6'),
                    formattedText("2023-Ayase,初音ミク - HERO (feat. 初音ミク)",'a'),
                    formattedText("2022-sasakure.UK,初音ミク - フューチャー?イヴ (feat. 初音ミク)",'b'),
                    formattedText("2021-cosMo@暴走P,初音ミク - 初音天地開闢神話",'e'),
                    formattedText("2020-ピノキオピー,初音ミク - 愛されなくても君がいる",'7'),
                    formattedText("2019-くらげP,初音ミク - ブレス?ユア?ブレス (feat. 初音ミク)",'7'),
                    formattedText("2018-初音ミク,Omoi - グリーンライツ?セレナーデ",'7'),
                    formattedText("2017-米津玄師,初音ミク - 砂の惑星",'7'),
                    formattedText("2016-初音ミク,みきとP - 39みゅーじっく!",'7'),
                    formattedText("2015-livetune 初音ミク - Hand in Hand",'7'),
                    formattedText("2014-さつき が てんこもり,初音ミク - NEXT NEST",'7'))
            );
    public static final Item ALBUM2 = new RecordItem(giteeRaw("2"),SETTINGS,33*60+30,
            List.of(formattedText("应该不会有人没听过八王子p的歌吧(雾)",'d'),
                    formattedText("歌曲列表",'6'),
                    formattedText("01-デスクトップ?シンデレラ",'a'),
                    formattedText("02-Little Scarlet Bad Girl",'b'),
                    formattedText("03-Yeah! Yeah!! Yeah!!!",'e'),
                    formattedText("04-Night Glitter",'7'),
                    formattedText("05-FUTURE DRIVER",'7'),
                    formattedText("06-CMYK",'7'),
                    formattedText("07-Beautiful Nightmare",'7'),
                    formattedText("08-Selfish Style",'7'),
                    formattedText("09-Happy Birthday",'7'))
            );
    public static final Item ALBUM3 = new RecordItem(giteeRaw("3"),SETTINGS,39*60+17,
            List.of(formattedText("2021年魔法未来演唱会歌单",'d'),
                    formattedText("歌曲列表:",'6'),
                    formattedText("01-初音天地開闢神話",'a'),
                    formattedText("02-ダーリンダンス",'b'),
                    formattedText("03-レイニースノードロップ",'e'),
                    formattedText("04 First Note",'7'),
                    formattedText("05 テルミーアンサー",'7'),
                    formattedText("06 テレキャスタービーボーイ",'7'),
                    formattedText("07 星空クロノグラフ",'7'),
                    formattedText("08 インタビュア",'7'),
                    formattedText("09 Parades",'7'),
                    formattedText("10 HappY EnD",'7'))
            );
    public static final Item ALBUM4 = new RecordItem(giteeRaw("4"),SETTINGS,31*60+40,
            List.of(formattedText("德哥你干嘛?",'d'),
                    formattedText("歌曲列表",'6'),
                    formattedText("01DECO＊27,堀江晶太 - セカイ",'a'),
                    formattedText("02DECO＊27,初音ミク - 妄想税",'b'),
                    formattedText("03DECO＊27,初音ミク - 愛言葉IV",'e'),
                    formattedText("04DECO＊27,初音ミク - ラビットホール",'7'),
                    formattedText("05DECO＊27,初音ミク - マネキン",'7'),
                    formattedText("06DECO＊27,初音ミク - パラサイト",'7'),
                    formattedText("07DECO＊27,初音ミク - サラマンダー (TAKU INOUE 3-Minutes Remix)",'7'),
                    formattedText("08DECO＊27,初音ミク - アンドロイドガール",'7'),
                    formattedText("09DECO＊27,初音ミク - Journey",'7'),
                    formattedText("10DECO＊27,ピノキオピー,初音ミク - デビルじゃないもん",'7'))
            );
    public static final Item ALBUM5 = new RecordItem(giteeRaw("5"),SETTINGS,31*60+41,
            List.of(formattedText("纪念wowaka......希望大家不会将他忘记.",'7'),
                    formattedText("歌曲列表",'7'),
                    formattedText("01wowaka,初音ミク - アンハッピーリフレイン",'7'),
                    formattedText("02wowaka,初音ミク - グレーゾーンにて。",'7'),
                    formattedText("03wowaka,初音ミク - とおせんぼ",'7'),
                    formattedText("04wowaka,初音ミク - プリズムキューブ",'7'),
                    formattedText("05wowaka,初音ミク - ローリンガール",'7'),
                    formattedText("06wowaka,初音ミク - 積み木の人形",'7'),
                    formattedText("07wowaka,初音ミク - 日常と地球の額縁",'7'),
                    formattedText("08wowaka,初音ミク - アンノウン?マザーグース",'7'),
                    formattedText("09wowaka,初音ミク,鏡音リン - 裏表ラバーズ×ロストワンの号哭",'7'))
            );
    public static final Item ALBUM6 = new RecordItem(giteeRaw("6"),SETTINGS,32*60+44,
            List.of(formattedText("我去!老匹.",'d'),
                    formattedText("歌曲列表",'6'),
                    formattedText("ピノキオピー - キラースパイダー",'a'),
                    formattedText("ピノキオピー - 甘噛みでおねがい",'b'),
                    formattedText("ピノキオピー,初音ミク - ノンブレス?オブリージュ",'e'),
                    formattedText("ピノキオピー,初音ミク - ラヴィット",'7'),
                    formattedText("ピノキオピー,初音ミク - 魔法少女とチョコレゐト",'7'),
                    formattedText("ピノキオピー,初音ミク - 内臓ありますか",'7'),
                    formattedText("ピノキオピー,初音ミク - 神っぽいな",'7'),
                    formattedText("ピノキオピー,初音ミク - 転生林檎",'7'),
                    formattedText("ピノキオピー,初音ミク,ARuFa - 匿名M (feat. 初音ミク ",'7'),
                    formattedText("ピノキオピー,初音ミク,DECO＊27 - デビルじゃないもん",'7'))
            );
    public static final Item ALBUM7 = new RecordItem(giteeRaw("7"),SETTINGS,45*60+39,
            List.of(formattedText("Miku的白丝...嘿嘿.",'b'),
                    formattedText("歌曲列表",'b'),
                    formattedText("012013-エレクトロソナー - SNOW GLITTER (feat. 初音ミク)",'b'),
                    formattedText("022014-Mitchie M,初音ミク - 好き！雪！本気(マジ)マジック",'b'),
                    formattedText("032015-40mP - Snow Fairy Story",'b'),
                    formattedText("042016-doriko,初音ミク - 雪がとける前に",'b'),
                    formattedText("052017-初音ミク,n-buna,Orangestar - スターナイトスノウ",'b'),
                    formattedText("062018-初音ミク,西沢さんP - 四角い地球を丸くする",'b'),
                    formattedText("072019-DECO＊27,初音ミク - アイ（AI）",'b'),
                    formattedText("082020-はるまきごはん,初音ミク - ぽかぽかの星 (feat. 初音ミク)",'b'),
                    formattedText("092021-初音ミク,Heavenz - Fondant Step (feat. 初音ミク)",'b'),
                    formattedText("102022-カルロス袴田,初音ミク - 君色マリンスノウ (feat. 初音ミク)",'b'),
                    formattedText("112023-まらしぃ,初音ミク - SnowMix? (feat. 初音ミク)",'b'))
            );
    public static final Item ALBUM8 = new RecordItem(giteeRaw("8"),SETTINGS,14*60+58,
            List.of(formattedText("经典!",'d'),
                    formattedText("歌曲列表",'6'),
                    formattedText("アメイジング?マジシャン",'a'),
                    formattedText("ビバハピ",'b'),
                    formattedText("ぶれないアイで",'e'),
                    formattedText("好き!雪!本気マジック",'7'),
                    formattedText("买买买",'7'))
            );

    private static Text formattedText(String text,char code){
        return Text.literal(text).formatted(Formatting.byCode(code));
    }

    public static void register(){
        register(ALBUM1,"album1");
        register(ALBUM2,"album2");
        register(ALBUM3,"album3");
        register(ALBUM4,"album4");
        register(ALBUM5,"album5");
        register(ALBUM6,"album6");
        register(ALBUM7,"album7");
        register(ALBUM8,"album8");
    }
    private static void register(Item item,String id){
        Registry.register(
                Registries.ITEM,
                RegistryUtils.identifier(id),
                item
        );
    }

    private static String giteeRaw(String name){
        return "https://ghps.cc/https://raw.githubusercontent.com/fufucraft/jukebox-media/main/%s.ogg".formatted(name);
    }
}
