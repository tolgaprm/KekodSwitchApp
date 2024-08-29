package com.prmto.kekodswitchapp.ui.emotion_detail

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class QuoteAdapter : ListAdapter<EmotionQuote, QuoteViewHolder>(QuoteListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}


class QuoteListDiffCallback : DiffUtil.ItemCallback<EmotionQuote>() {
    override fun areItemsTheSame(oldItem: EmotionQuote, newItem: EmotionQuote): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EmotionQuote, newItem: EmotionQuote): Boolean {
        return oldItem == newItem
    }
}