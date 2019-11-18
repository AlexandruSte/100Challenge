# https://www.codewars.com/kata/find-the-unique-number-1/train/ruby
def find_uniq(arr)
  freq = arr.inject(Hash.new(0)) { |h,v| h[v] += 1; h }
  arr.min_by { |v| freq[v] }
end