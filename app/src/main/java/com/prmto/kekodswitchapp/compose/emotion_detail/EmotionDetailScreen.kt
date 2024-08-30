package com.prmto.kekodswitchapp.compose.emotion_detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.compose.emotion_detail.components.BodyText
import com.prmto.kekodswitchapp.compose.emotion_detail.components.QuoteItem
import com.prmto.kekodswitchapp.compose.emotion_detail.components.TitleText
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetail
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionQuote
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun EmotionDetailScreen(
    modifier: Modifier = Modifier,
    emotionDetail: EmotionDetail
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
    ) {
        item {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = emotionDetail.emotionImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = emotionDetail.emotion.name.lowercase().replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )

            TitleText(text = stringResource(id = R.string.description))

            Spacer(modifier = Modifier.height(8.dp))

            BodyText(text = emotionDetail.emotionDescription)

            Spacer(modifier = Modifier.height(16.dp))

            TitleText(text = stringResource(id = R.string.quotes))
        }

        items(emotionDetail.emotionQuote) { quote ->
            QuoteItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                quote = quote
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            TitleText(text = stringResource(id = R.string.statictic))

            Spacer(modifier = Modifier.height(8.dp))

            BodyText(text = emotionDetail.emotionStaticsText)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmotionDetailPreview() {
    EmotionDetailScreen(
        emotionDetail = EmotionDetail(
            emotion = Emotion.HAPPINESS,
            emotionDescription = "Mutluluk, iyi olma ve memnuniyet hali olup, neşe, tatmin ve doyum duyguları ile karakterizedir. Genellikle yaşamın nihai hedefi olarak kabul edilir ve ilişkiler, başarılar ve kişisel gelişim gibi çeşitli faktörlerden etkilenebilir.",
            emotionImageUrl = "https://neurosciencenews.com/files/2023/05/happiness-timing-neurosicenec.jpg",
            emotionQuote = listOf(
                EmotionQuote(
                    id = 100,
                    quote = "Mutluluk, başkalarının mutluluğunu istemektir.",
                    author = "Aristoteles"
                ),
                EmotionQuote(
                    id = 101,
                    quote = "Mutluluk hazır bir şey değildir. Kendi eylemlerinizden gelir.",
                    author = "Dalai Lama"
                ),
                EmotionQuote(
                    id = 102,
                    quote = "Hayatımınız amacı mutlu olmaktır.",
                    author = "Dalai Lama"
                ),
                EmotionQuote(
                    id = 103,
                    quote = "Mutluluk, düşündüğünüz, söylediğiniz ve yaptığınız şeylerin uyum içinde olduğu zamandır",
                    author = "Mahatma Gandhi"
                )
            ),
            emotionStaticsText = "Mutlu insanların %40 daha uzun yaşadığı gözlemlenmiştir."
        )
    )
}