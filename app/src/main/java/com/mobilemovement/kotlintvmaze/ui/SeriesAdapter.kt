/*
 * Copyright 2019 nuhkoca.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobilemovement.kotlintvmaze.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mobilemovement.kotlintvmaze.base.BaseViewHolder
import com.mobilemovement.kotlintvmaze.base.util.delegate.AdapterItem
import com.mobilemovement.kotlintvmaze.base.util.delegate.DelegateAdapter
import com.mobilemovement.kotlintvmaze.base.util.ext.fromHtml
import com.mobilemovement.kotlintvmaze.base.util.ext.inflater
import com.mobilemovement.kotlintvmaze.base.util.ext.use
import com.mobilemovement.kotlintvmaze.data.SeriesViewItem
import com.mobilemovement.kotlintvmaze.databinding.LayoutSeriesRowItemBinding

class SeriesAdapter : DelegateAdapter {

    override fun createViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutSeriesRowItemBinding.inflate(parent.context.inflater)
        return SeriesViewHolder(view.root)
    }

    override fun bindViewHolder(holder: ViewHolder, item: AdapterItem) {
        holder as SeriesViewHolder
        holder.bindTo(item)
    }

    override fun isForViewType(item: AdapterItem): Boolean = item is SeriesViewItem

    class SeriesViewHolder(itemView: View) :
        BaseViewHolder<LayoutSeriesRowItemBinding, AdapterItem>(itemView) {
        override fun bindTo(item: AdapterItem) {
            with(item as SeriesViewItem) {
                dataBinding.use {
                    tvName.text = show?.name
                    tvSummary.text = show?.summary?.fromHtml()

                    imageUrl = show?.image?.original
                }
            }
        }
    }
}
