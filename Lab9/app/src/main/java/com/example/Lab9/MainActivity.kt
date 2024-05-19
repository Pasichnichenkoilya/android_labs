package com.example.Lab9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.Lab9.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var database: DailyPlanDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            DailyPlanDB::class.java, "plan_database"
        ).build()
        val planDao = database.planDao()

        binding.addBtn.setOnClickListener{
            val name = binding.name.text.toString()
            val description = binding.description.text.toString()
            val deadline = binding.deadline.text.toString()
            val dailyPlan = DailyPlan(name = name, description = description, deadline = deadline)
            GlobalScope.launch {
                planDao.insertAll(dailyPlan)
            }
            Toast.makeText( applicationContext, "Plan created", Toast.LENGTH_LONG).show()
        }

        binding.allPlans.setOnClickListener{
            GlobalScope.launch {
                val plans = planDao.getAll()
                var plansInfo = ""
                plans.forEach{
                    plansInfo += "${it.id}: ${it.name} ${it.description} ${it.deadline}\n"
                }
                runOnUiThread{
                    binding.textView.text = plansInfo
                }
            }
        }

        binding.deleteButton.setOnClickListener{
            val planId = binding.idText.text.toString().toIntOrNull()

            if (planId == null || planId < 0) {
                Toast.makeText(this, "Invalid index.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                planDao.deleteById(planId)

                GlobalScope.launch {
                    val plans = planDao.getAll()
                    var plansInfo = ""
                    plans.forEach{
                        plansInfo += "${it.id}: ${it.name} ${it.description} ${it.deadline}\n"
                    }
                    runOnUiThread{
                        binding.textView.text = plansInfo
                    }
                }
            }
        }

        GlobalScope.launch {
            val plans = planDao.getAll()
            var plansInfo = ""
            plans.forEach{
                plansInfo += "${it.id}: ${it.name} ${it.description} ${it.deadline}\n"
            }
            runOnUiThread{
                binding.textView.text = plansInfo
            }
        }
    }
}

