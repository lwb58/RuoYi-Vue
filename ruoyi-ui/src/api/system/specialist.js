import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listSpecialist(query) {
  return request({
    url: '/system/specialist/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getSpecialist(id) {
  return request({
    url: '/system/specialist/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addSpecialist(data) {
  return request({
    url: '/system/specialist',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateSpecialist(data) {
  return request({
    url: '/system/specialist',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delSpecialist(id) {
  return request({
    url: '/system/specialist/' + id,
    method: 'delete'
  })
}
