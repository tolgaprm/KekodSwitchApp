package com.prmto.kekodswitchapp.compose.emotion_detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionQuote

@Composable
fun QuoteItem(
    modifier: Modifier = Modifier,
    quote: EmotionQuote
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.gray))
    ) {
        BodyText(
            modifier = Modifier.padding(8.dp),
            text = quote.quote
        )

        BodyText(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            text = quote.author,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.End
        )
    }
}


@Preview
@Composable
private fun QuoteItemPreview() {
    QuoteItem(
        quote =
        EmotionQuote(
            id = 103,
            quote = "Mutluluk, düşündüğünüz, söylediğiniz ve yaptığınız şeylerin uyum içinde olduğu zamandır",
            author = "Mahatma Gandhi"
        )
    )
}