package com.konokradus.schedulefornatcteachers.shared.domain.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NatkDB
@Inject
constructor(

) {
    val url: String = "jdbc:mysql://91.227.68.11:3306/pl4453-mobile"
    val user: String = "sura_dm"
    val password: String = "X5f5D3u8"

    var rs: ResultSet? = null

        fun getTeachers(
            fio: String = "",
            connection: Connection
        ): MutableList<String> {
            val statement = connection.createStatement()
            var listTeachers = mutableListOf<String>()
            val queryTeacher: String =
                "SELECT DISTINCT `prepod`" +
                        "FROM `1c_shedule`" +
                        "WHERE `prepod` LIKE N'%$fio%'" +
                        "ORDER BY `1c_shedule`.`prepod`  ASC"
            rs = statement?.executeQuery(queryTeacher)
            while (rs!!.next()) {
                if (rs?.getString("prepod") != "")
                    rs?.getString("prepod")?.let { listTeachers.add(it) }
            }
            return listTeachers
        }

        fun getTeacherSchedule(
            fio: String,
            dbDate: String,
            connection: Connection
        ): ResultSet? {
            val statement = connection.createStatement()
            val queryTeacherSchedule: String =
                "SELECT `gruppa` , `disciplina` , `auditoria` , `vremya` , `data`" +
                        "FROM `1c_shedule`" +
                        "WHERE `prepod` LIKE N'%$fio%' AND `data` LIKE '%$dbDate%'" +
                        "ORDER BY `1c_shedule`.`data` ASC , `vremya` ASC"
            rs = statement?.executeQuery(queryTeacherSchedule)
            return rs
        }

        fun getDistinctScheduleData(
            fio: String,
            connection: Connection
        ): ResultSet? {
            val statement = connection.createStatement()
            val queryDistinctScheduleData: String =
                "SELECT DISTINCT `data`" +
                        "FROM `1c_shedule`" +
                        "WHERE `prepod` LIKE N'%$fio%'" +
                        "ORDER BY `1c_shedule`.`data` ASC , `vremya` ASC"
            rs = statement?.executeQuery(queryDistinctScheduleData)
            return rs
        }
    }

