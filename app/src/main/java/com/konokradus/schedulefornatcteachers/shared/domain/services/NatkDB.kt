package com.konokradus.schedulefornatcteachers.shared.domain.services

import java.sql.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NatkDB
@Inject
constructor(

) {
    private val url: String = "jdbc:mysql://91.227.68.11:3306/pl4453-mobile"
    private val user: String = "sura_dm"
    private val password: String = "X5f5D3u8"

    private var con: Connection?
    private var stmt: Statement?
    private var rs: ResultSet?

    init {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, user, password)
        stmt = con?.createStatement()
        rs = null
    }

    fun getAllTeachers(): List<String> {
        var listTeachers = mutableListOf<String>()
        val queryAllTeachers: String =
            "SELECT DISTINCT `prepod` " +
                    "FROM `1c_shedule` " +
                    "WHERE 1 " +
                    "ORDER BY `1c_shedule`.`prepod` ASC"
        rs = stmt?.executeQuery(queryAllTeachers)
        while (rs!!.next()) {
            rs?.getString("prepod")?.let { listTeachers.add(it) }
        }
        return listTeachers
    }

    fun getOneTeacher(fio: String): MutableList<String> {
        var listTeachers = mutableListOf<String>()
        val queryOneTeacher: String =
            "SELECT DISTINCT `prepod`" +
                "FROM `1c_shedule`" +
                "WHERE `prepod` LIKE '%$fio%'" +
                "ORDER BY `1c_shedule`.`prepod` ASC"
        rs = stmt?.executeQuery(queryOneTeacher)
        rs?.getString("prepod")?.let { listTeachers.add(it) }
        return listTeachers
    }

    fun getTeacherSchedule(fio: String): ResultSet? {
        val queryTeacherSchedule: String =
            "SELECT `gruppa` , `disciplina` , `auditoria` , `vremya` , `data`" +
                "FROM `1c_shedule`" +
                "WHERE `prepod` LIKE '%$fio%'" +
                "ORDER BY `1c_shedule`.`data` ASC , `vremya` ASC"
        rs = stmt?.executeQuery(queryTeacherSchedule)
        return rs
    }
}