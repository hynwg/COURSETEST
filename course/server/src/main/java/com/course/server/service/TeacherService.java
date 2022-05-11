package com.course.server.service;

import com.course.server.dao.TeacherMapper;
import com.course.server.entity.Teacher;
import com.course.server.entity.TeacherExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.TeacherPageVo;
import com.course.server.vo.TeacherVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 分页查询
     *
     * @param teacherPageVo
     */
    public void query(TeacherPageVo teacherPageVo) {
        PageHelper.startPage(teacherPageVo.getPage(), teacherPageVo.getSize());
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teacherList);
        teacherPageVo.setTotal(pageInfo.getTotal());
        List<TeacherVo> teacherVoList = CopyUtil.copyList(teacherList, TeacherVo.class);
        teacherPageVo.setList(teacherVoList);
    }

    /**
     * 保存
     *
     * @param teacherVo
     */
    public void save(TeacherVo teacherVo) {
        Teacher teacher = CopyUtil.copy(teacherVo, Teacher.class);
        if (teacher.getId() == null) {

            teacherMapper.insert(teacher);
        } else {
            teacherMapper.updateByPrimaryKey(teacher);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id) {
        teacherMapper.deleteByPrimaryKey(id);
    }
}
