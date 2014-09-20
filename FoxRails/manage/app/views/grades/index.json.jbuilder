json.array!(@grades) do |grade|
  json.extract! grade, :id, :grade, :profession, :college
  json.url grade_url(grade, format: :json)
end
