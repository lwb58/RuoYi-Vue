import request from '@/utils/request'

// 查询抽取专家设置列表
export function listCqzjconfig(query) {
  return request({
    url: '/system/cqzjconfig/list',
    method: 'get',
    params: query
  })
}

// 查询抽取专家设置详细
export function getCqzjconfig(id) {
  return request({
    url: '/system/cqzjconfig/' + id,
    method: 'get'
  })
}

// 新增抽取专家设置
export function addCqzjconfig(data) {
  return request({
    url: '/system/cqzjconfig',
    method: 'post',
    data: data
  })
}

// 修改抽取专家设置
export function updateCqzjconfig(data) {
  return request({
    url: '/system/cqzjconfig',
    method: 'put',
    data: data
  })
}

// 删除抽取专家设置
export function delCqzjconfig(id) {
  return request({
    url: '/system/cqzjconfig/' + id,
    method: 'delete'
  })
}
