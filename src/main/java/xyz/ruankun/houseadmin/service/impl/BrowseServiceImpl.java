package xyz.ruankun.houseadmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import xyz.ruankun.houseadmin.entity.Browse;
import xyz.ruankun.houseadmin.mapper.BrowseMapper;
import xyz.ruankun.houseadmin.service.BrowseService;

/**
 * ---------------------------
 * 房源浏览记录 (BrowseServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-12-31 11:26:01
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class BrowseServiceImpl implements BrowseService {

	@Autowired
	private BrowseMapper browseMapper;

	@Override
	public int save(Browse record) {
		if(record.getId() == null || record.getId() == 0) {
			return browseMapper.add(record);
		}
		return browseMapper.update(record);
	}

	@Override
	public int delete(Browse record) {
		return browseMapper.delete(record.getId());
	}

	@Override
	public int delete(List<Browse> records) {
		for(Browse record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Browse findById(Long id) {
		return browseMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, browseMapper);
	}
	
}
