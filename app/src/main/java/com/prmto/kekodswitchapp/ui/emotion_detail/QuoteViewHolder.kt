package com.prmto.kekodswitchapp.ui.emotion_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prmto.kekodswitchapp.databinding.QuoteItemBinding

class QuoteViewHolder(
    private val binding: QuoteItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): QuoteViewHolder {
            return QuoteViewHolder(
                QuoteItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }


    fun bind(quote: EmotionQuote) {
        binding.apply {
            tvQuote.text = quote.quote
            tvAuthor.text = quote.author
        }
    }
}