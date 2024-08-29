package com.prmto.kekodswitchapp.data

import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetail
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionQuote
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

class EmotionRepositoryImpl : EmotionRepository {
    override fun getEmotionDetail(emotion: Emotion): EmotionDetail {
        return emotionDetailData.find { it.emotion == emotion }
            ?: throw IllegalArgumentException("Emotion not found")
    }
}

private val happinessDetail = EmotionDetail(
    emotion = Emotion.HAPPINESS,
    emotionDescription = "Mutluluk, iyi olma ve memnuniyet hali olup, neşe, tatmin ve doyum duyguları ile karakterizedir. Genellikle yaşamın nihai hedefi olarak kabul edilir ve ilişkiler, başarılar ve kişisel gelişim gibi çeşitli faktörlerden etkilenebilir.",
    emotionImageUrl = "https://neurosciencenews.com/files/2023/05/happiness-timing-neurosicenec.jpg",
    emotionQuote = listOf(
        EmotionQuote(
            quote = "Mutluluk, başkalarının mutluluğunu istemektir.",
            author = "Aristoteles"
        ),
        EmotionQuote(
            quote = "Mutluluk hazır bir şey değildir. Kendi eylemlerinizden gelir.",
            author = "Dalai Lama"
        ),
        EmotionQuote(
            quote = "Hayatımınız amacı mutlu olmaktır.",
            author = "Dalai Lama"
        ),
        EmotionQuote(
            quote = "Mutluluk, düşündüğünüz, söylediğiniz ve yaptığınız şeylerin uyum içinde olduğu zamandır",
            author = "Mahatma Gandhi"
        )
    ),
    emotionStaticsText = "Mutlu insanların %40 daha uzun yaşadığı gözlemlenmiştir."
)

private val optimisticDetail = EmotionDetail(
    emotion = Emotion.OPTIMISTIC,
    emotionDescription = "İyimserlik, hayata olumlu bir bakış açısına sahip olma ve olumlu sonuçlar bekleme eğilimidir. İyimser bireyler, zorluklarda fırsatlar görür ve zor durumlarda bile olumlu bir tutum sergilerler.",
    emotionImageUrl = "https://www.verywellmind.com/thmb/Siin74YQnLckW2s_bBIv6W5qqzM=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1189376727-9cee76278b104778bf76f2cb6dd20e51.jpg",
    emotionQuote = listOf(
        EmotionQuote(
            quote = "Yüzünüzü her zaman güneşe doğru tutun—gölgeler arkanızda kalacaktır.",
            author = "Walt Whitman"
        ),
        EmotionQuote(
            quote = "Kötümser her fırsatta zorluk görür. İyimser her zorlukta fırsat görür.",
            author = "Winston Churchill"
        ),
        EmotionQuote(
            quote = "İyimserlik, başarıya götüren inançtır. Umut ve güven olmadan hiçbir şey yapılamaz.",
            author = "Helen Keller"
        )
    ),
    emotionStaticsText = "İyimser insanların %30 daha az stres yaşadığı gözlemlenmiştir.",
)

private val kindessDetail = EmotionDetail(
    emotion = Emotion.KINDNESS,
    emotionDescription = "Naziklik, arkadaş canlısı, cömert ve düşünceli olma kalitesidir. Genellikle karşılık beklemeden başkalarına şefkat ve empati gösteren davranışları içerir. Naziklik, hem veren hem de alan üzerinde olumlu bir etki yaratabilir, topluluk ve iyi olma duygusunu pekiştirebilir.",
    emotionImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl08xrf8obVz3a3d1mAZc-HWlV80Rgqgpo9g&s",
    emotionQuote = listOf(
        EmotionQuote(
            quote = "Hiçbir nazik davranış, ne kadar küçük olursa olsun, boşa gitmez.",
            author = "Ezop"
        ),
        EmotionQuote(
            quote = "Naziklik, sağırların duyabileceği ve körlerin görebileceği dildir.",
            author = "Mark Twain"
        ),
        EmotionQuote(
            quote = "Tek bir nazik davranış, her yöne kökler atar ve bu kökler yeni ağaçlar oluşturur.",
            author = "Amelia Earhart"
        )
    ),
    emotionStaticsText = "Nazik insanların %25 daha fazla sosyal bağlantıya sahip olduğu gözlemlenmiştir.",
)

private val givingDetail = EmotionDetail(
    emotion = Emotion.GIVING,
    emotionDescription = "Vermek, başkalarına sevgi, destek veya kaynak sağlama eylemidir. Genellikle cömertlik ve özveri ile ilişkilendirilir ve hayır kurumlarına bağış yapma, gönüllü çalışma veya basitçe yardım eli uzatma gibi birçok formda olabilir. Vermek, kişisel mutluluğu artırabilir ve sosyal bağları güçlendirebilir.",
    emotionImageUrl = "https://media.istockphoto.com/id/950835384/photo/mother-and-children-work-at-local-food-bank-together.jpg?s=612x612&w=0&k=20&c=_aSpx9n4oSHUFQyaAQLS-QWKw82tNYAtphuGH28n8jM%3D",
    emotionQuote = listOf(
        EmotionQuote(
            quote = "Kendinizi bulmanın en iyi yolu, kendinizi başkalarına hizmet etmeye kaybetmektir.",
            author = "Mahatma Gandhi"
        ),
        EmotionQuote(
            quote = "Geçimimizi kazandıklarımızla sağlarız, ama hayatımızı verdiklerimizle yaparız.",
            author = "Winston Churchill"
        ),
        EmotionQuote(
            quote = "Vermek sadece bağış yapmakla ilgili değildir. Fark yaratmakla ilgilidir.",
            author = "Kathy Calvin"
        )
    ),
    emotionStaticsText = "Yardımsever insanların %20 daha mutlu olduğu gözlemlenmiştir.",
)

private val respectDetail = EmotionDetail(
    emotion = Emotion.RESPECT,
    emotionDescription = "Saygı, birine veya bir şeye duyulan derin hayranlık duygusudur ve onların yetenekleri, nitelikleri veya başarıları tarafından tetiklenir. Başkalarının değerini ve onurunu tanımayı ve onlara saygı ve hürmetle davranmayı içerir. Saygı, sağlıklı ilişkiler kurmanın ve uyumlu bir toplum oluşturmanın temelidir.",
    emotionImageUrl = "https://www.freshbooks.com/wp-content/uploads/2022/03/gain-respect-from-employees.jpg",
    emotionQuote = listOf(
        EmotionQuote(
            quote = "Kendine saygı duy ve başkaları da sana saygı duyacaktır.",
            author = "Konfüçyüs"
        ),
        EmotionQuote(
            quote = "Herkesle aynı şekilde konuşurum, ister çöpçü olsun ister üniversite başkanı.",
            author = "Albert Einstein"
        ),
        EmotionQuote(
            quote = "Saygı, sevginin en büyük ifadelerinden biridir.",
            author = "Miguel Angel Ruiz"
        )
    ),
    emotionStaticsText = "Saygılı insanların %15 daha az çatışma yaşadığı gözlemlenmiştir.",
)

private val egoDetail = EmotionDetail(
    emotion = Emotion.EGO,
    emotionDescription = "Ego, bir kişinin özsaygı veya kendine önem verme duygusudur. Bireyleri büyük şeyler başarmaya yönlendirebilir, ancak kontrol edilmezse kibir ve bencillik davranışlarına yol açabilir. Sağlıklı bir egoyu alçakgönüllülük ve empati ile dengelemek, kişisel gelişim ve olumlu ilişkiler için esastır.",
    emotionImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6myp_hc3wLD3ijlChk3ev_9WIFH5aiw31Qw&s",
    emotionQuote = listOf(
        EmotionQuote(
            quote = "Ego, kendi evinde efendi değildir.",
            author = "Sigmund Freud"
        ),
        EmotionQuote(
            quote = "Bilgi arttıkça ego azalır. Bilgi azaldıkça ego artar.",
            author = "Albert Einstein"
        ),
        EmotionQuote(
            quote = "Egonun nihai amacı bir şey görmek değil, bir şey olmaktır.",
            author = "Muhammed İkbal"
        )
    ),
    emotionStaticsText = "Egolu insanların %10 daha az empati gösterdiği gözlemlenmiştir."
)

private val emotionDetailData = listOf(
    happinessDetail,
    optimisticDetail,
    kindessDetail,
    givingDetail,
    respectDetail,
    egoDetail
)