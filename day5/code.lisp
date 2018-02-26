(defun next-index (index current-value offset)
  (let ((result (+ index current-value)))
    (if (< result (length offset))
      result
      nil)))

(defun next-offset (index offsets)
  (let* ((current-value (nth index offsets)))
    (list (next-index index current-value offsets)
          (replace (copy-list offsets) (list (1+ current-value)) :start1 index))))

(defun count-steps (index offsets)
  (if index
    (1+ (apply #'count-steps (next-offset index offsets)))
    0))

(defun file-to-list (path)
  (with-open-file (input path)
    (loop for line = (read input nil)
      while line collect line)))

(defun solution ()
  (let ((index 0)
        (offsets (file-to-list "input.txt")))
    (count-steps index offsets)))
