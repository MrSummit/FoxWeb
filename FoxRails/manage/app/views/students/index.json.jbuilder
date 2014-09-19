json.array!(@students) do |student|
  json.extract! student, :id, :number, :name, :sex, :password, :class_id, :college, :year, :entrollmentTime, :orgin, :salt
  json.url student_url(student, format: :json)
end
