package com.delgado.angel.laboratoriocalificado03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delgado.angel.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    var list: List<TeacherResponse>,
    private val onItemClick: (TeacherResponse) -> Unit,
    private val onItemLongClick: (TeacherResponse) -> Unit
): RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemTeacherBinding.bind(view)

        fun bind(teacher: TeacherResponse) {
            binding.tvName.text = teacher.name
            binding.tvLastName.text = teacher.lastName
            binding.tvPhoneNumber.text = teacher.phoneNumber
            binding.tvEmail.text = teacher.email

            binding.root.setOnClickListener {
                onItemClick(teacher)
            }

            binding.root.setOnLongClickListener {
                onItemLongClick(teacher)
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemTeacherBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        return ViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemTeacher = list[position]
        holder.bind(itemTeacher)
    }

    override fun getItemCount(): Int = list.size

}