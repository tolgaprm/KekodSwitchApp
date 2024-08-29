package com.prmto.kekodswitchapp.ui.emotion_detail

import app.cash.turbine.test
import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalCoroutinesApi::class)
class EmotionDetailViewModelTest {

    private val viewModel: EmotionDetailViewModel = EmotionDetailViewModel()

    @OptIn(ExperimentalTime::class)
    @Test
    fun `getEmotionDetail when  `() = runTest {
        viewModel.getEmotionDetail(Emotion.RESPECT)
        viewModel.emotionDetail.test {
            assertThat(awaitItem()).isEqualTo(respectExpectedEmotionDetail)
        }
    }

    @Test
    fun `getEmotionDetail when error  `() = runTest {
        assertFailure {
            viewModel.getEmotionDetail(Emotion.valueOf(""))
        }.isInstanceOf(IllegalArgumentException::class)
    }

    private val respectExpectedEmotionDetail = EmotionDetail(
        emotion = Emotion.RESPECT,
        emotionDescription = "Saygı, birine veya bir şeye duyulan derin hayranlık duygusudur ve onların yetenekleri, nitelikleri veya başarıları tarafından tetiklenir. Başkalarının değerini ve onurunu tanımayı ve onlara saygı ve hürmetle davranmayı içerir. Saygı, sağlıklı ilişkiler kurmanın ve uyumlu bir toplum oluşturmanın temelidir.",
        emotionImageUrl = "https://www.freshbooks.com/wp-content/uploads/2022/03/gain-respect-from-employees.jpg",
        emotionQuote = listOf(
            EmotionQuote(
                id = 113,
                quote = "Kendine saygı duy ve başkaları da sana saygı duyacaktır.",
                author = "Konfüçyüs"
            ),
            EmotionQuote(
                id = 114,
                quote = "Herkesle aynı şekilde konuşurum, ister çöpçü olsun ister üniversite başkanı.",
                author = "Albert Einstein"
            ),
            EmotionQuote(
                id = 115,
                quote = "Saygı, sevginin en büyük ifadelerinden biridir.",
                author = "Miguel Angel Ruiz"
            )
        ),
        emotionStaticsText = "Saygılı insanların %15 daha az çatışma yaşadığı gözlemlenmiştir.",
    )
}