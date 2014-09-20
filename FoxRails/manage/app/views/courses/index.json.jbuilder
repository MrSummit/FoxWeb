json.array!(@courses) do |course|
  json.extract! course, :id, :course_name, :course_id, :year, :course_begin, :course_end, :lesson_begin, :lesson_end, :course_day, :teacher, :place, :grade_id
  json.url course_url(course, format: :json)
end
