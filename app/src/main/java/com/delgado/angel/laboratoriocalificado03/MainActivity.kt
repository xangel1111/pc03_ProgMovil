package com.delgado.angel.laboratoriocalificado03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.delgado.angel.laboratoriocalificado03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var listTeacher: List<TeacherResponse> = emptyList()

    private val adapter by lazy {
        TeacherAdapter(listTeacher,
            onItemClick = { teacher ->
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${teacher.phoneNumber}")
                }
                startActivity(intent)
            },
            onItemLongClick = { teacher ->
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${teacher.email}")
                }
                startActivity(intent)
            }
        )
    }

    private val viewModel by lazy { MainViewModel() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvTeacher.layoutManager = LinearLayoutManager(this)
        binding.rvTeacher.adapter = adapter
        observeValues();
    }

    private fun observeValues() {
        viewModel.teacherList.observe(this) { teacherList ->
            adapter.list =  teacherList
            adapter.notifyDataSetChanged()
        }

        viewModel.errorApi.observe(this) { errorMessage ->
            showMessage(errorMessage)
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}