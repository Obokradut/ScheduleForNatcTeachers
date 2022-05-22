package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases


import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.LessonItem
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.LessonItemGroup
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
import java.sql.Connection
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GetLessonItemGroup
@Inject
constructor(
    private val natkDB: NatkDB
) {
    fun sortGroup(
        fio: String,
        connection: Connection
    ): MutableList<LessonItemGroup> {
        val lessonsList = mutableListOf<LessonItemGroup>()
        var oneLessonItemGroup: LessonItemGroup
        var lessonDate: String
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        var date: Date
        val rs = natkDB.getDistinctScheduleData(
            fio = fio,
            connection = connection
        )
        try {
            while (rs!!.next()) {
                val lessons = mutableListOf<LessonItem>()
                rs.getString("data").also { dbDate ->
                    lessonDate = dbDate.dropLast(11)
                    date = formatter.parse(lessonDate) as Date
                    lessonDate = getDayOfWeek(date) + " — " + editDate(lessonDate)
                    val rs2 = natkDB.getTeacherSchedule(
                        fio = fio,
                        dbDate = dbDate.dropLast(11),
                        connection = connection
                    )
                    while (rs2!!.next()){
                        val lessonItem = LessonItem("","","","")
                        rs2.getString("disciplina").also { lesson ->
                            lessonItem.lesson = lesson
                        }
                        rs2.getString("vremya").also { time ->
                            lessonItem.timeStartEnd = time.replace(";","-")
                        }
                        rs2.getString("gruppa").also { group ->
                            lessonItem.group = group
                        }
                        rs2.getString("auditoria").also { auditorium ->
                            lessonItem.auditorium = getAuditorium(auditorium)
                        }
                        lessons.add(lessonItem)
                    }
                    oneLessonItemGroup = LessonItemGroup(lessonDate,lessons)
                    lessonsList.add(oneLessonItemGroup)
                }
            }
            return lessonsList
        }catch (ex: Exception) {
            val lessons = mutableListOf<LessonItem>()
            oneLessonItemGroup = LessonItemGroup("Расписание отсутствует", lessons)
            lessonsList.add(oneLessonItemGroup)
            return lessonsList
        }
    }
}