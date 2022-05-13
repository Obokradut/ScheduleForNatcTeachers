package com.konokradus.schedulefornatcteachers.modules.core.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.ScheduleMainContainer
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleForNatcTeachersTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.DriverManager

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ScheduleForNatcTeachersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /*Box(modifier = Modifier.fillMaxSize()) {
                        Text(text = Task().x())
                    }*/
                    ScheduleMainContainer()
                }
            }
        }
    }
    class Task() : ViewModel() {
        var records = "213121"
        init {
            viewModelScope.launch(Dispatchers.IO){
                    Class.forName("com.mysql.jdbc.Driver")
                    val connection = DriverManager.getConnection(
                        "jdbc:mysql://91.227.68.11:3306/pl4453-mobile",
                        "sura_dm",
                        "X5f5D3u8"
                    )
                    val statement = connection.createStatement()
                val resultSet =
                    statement.executeQuery("SELECT DISTINCT `prepod` FROM `1c_shedule` WHERE 1 ORDER BY `1c_shedule`.`prepod` ASC")
                while (resultSet.next()) {
                    records += resultSet.getString("prepod")
                }
            }
        }

        fun x():String {
            return records
        }
    }
}

